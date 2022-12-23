package it.yoomee.testplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.Toast;

/**
 * This class echoes a string called from JavaScript.
 */
public class YoomeeTestPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("showNativeToast")) {
            String message = args.getString(0);
            this.showNativeToast(message, callbackContext);
            return true;
        }
        return false;
    }

    private void showNativeToast(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            Toast toast = Toast.makeText(this.cordova.getActivity().getApplicationContext(), "Test Plugin!", Toast.LENGTH_SHORT);
            toast.show();

            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
