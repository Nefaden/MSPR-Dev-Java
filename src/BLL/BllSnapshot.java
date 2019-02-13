package BLL;

// This sample uses Apache HttpComponents:
// http://hc.apache.org/httpcomponents-core-ga/httpcore/apidocs/
// https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/

import IHM.IhmSnapshot;
import com.github.sarxos.webcam.Webcam;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * This controller manage the webcam to take photo (helped by the IHM IhmSnapshot)
 * List of methods :
 * 1. [public void or boolean] take picture
 * 2. [public void] checkPicture
 */

public class BllSnapshot extends BllGenericController implements ActionListener, WindowListener {

    public BllSnapshot(BllMainController bllMainController) throws SQLException {
        super(bllMainController);
        view = new IhmSnapshot();
        this.getView().getjPanelVisionCheck();
        this.getView().getjButtonAuth().addActionListener(this);
    }

    public IhmSnapshot getView() {
        return(IhmSnapshot) view;
    }

    public void takePicture() throws IOException {
        Webcam webcam = Webcam.getDefault();
        ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));
    }

    // Replace <Subscription Key> with your valid subscription key.
    private static final String subscriptionKey = "e4b04f32eda14b88a6a8895c1b8eb1ad";

    private static final String uriBase = "https://westus.api.cognitive.microsoft.com/face/v1.0/detect";

    private static final String imageWithFaces = "{\"url\":\"https://upload.wikimedia.org/wikipedia/commons/c/c3/RH_Louise_Lillian_Gish.jpg\"}";

    private static final String faceAttributes = "age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise";

    public void checkPicture() {
        HttpClient httpclient = HttpClientBuilder.create().build();

        try {
            URIBuilder builder = null;
            try {
                builder = new URIBuilder(uriBase);
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }

            // Request parameters. All of them are optional.
            builder.setParameter("returnFaceId", "true");
            builder.setParameter("returnFaceLandmarks", "false");
            builder.setParameter("returnFaceAttributes", faceAttributes);

            // Prepare the URI for the REST API call.
            URI uri = null;
            try {
                uri = builder.build();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
            HttpPost request = new HttpPost(uri);

            // Request headers.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

            // Request body.
            StringEntity reqEntity = null;
            try {
                reqEntity = new StringEntity(imageWithFaces);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            request.setEntity(reqEntity);

            // Execute the REST API call and get the response entity.
            HttpResponse response = null;
            try {
                response = httpclient.execute(request);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // Format and display the JSON response.
                System.out.println("REST Response:\n");

                String jsonString = null;
                try {
                    jsonString = EntityUtils.toString(entity).trim();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (jsonString.charAt(0) == '[') {
                    JSONArray jsonArray = new JSONArray(jsonString);
                    System.out.println(jsonArray.toString(2));
                } else if (jsonString.charAt(0) == '{') {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    System.out.println(jsonObject.toString(2));
                } else {
                    System.out.println(jsonString);
                }
            }
        } catch (Exception e) {
            // Display error message.
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getView().getjButtonAuth())) {
            try {
                takePicture();
                this.getMainController().action(EnumAction.DISPLAY_LIST_MATERIAL);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
