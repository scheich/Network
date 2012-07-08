/***
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package de.mangelow.network;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class RadioNetwork extends Activity {
	 private TelephonyManager tm;
	 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS) {
			Toast.makeText(getBaseContext(), "UMTS", Toast.LENGTH_LONG).show();
        }
        if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_EDGE) {
			Toast.makeText(getBaseContext(), "EDGE", Toast.LENGTH_LONG).show();
        }
        if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_GPRS) {
			Toast.makeText(getBaseContext(), "GPRS", Toast.LENGTH_LONG).show();
        }
        if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_UNKNOWN) {
			Toast.makeText(getBaseContext(), "UNKNOWN", Toast.LENGTH_LONG).show();
        }


		Intent i = new Intent();
		i.setClassName( "com.android.settings", "com.android.settings.RadioInfo" );
		startActivity(i);
		finish();
    }
}
