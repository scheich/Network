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
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class RadioNetwork extends Activity {

	private Context context;	
	private TelephonyManager tm;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = getApplicationContext();

		// Toast current Network Type
		tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String type = "UNKOWN";
		if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS)type = "UMTS";
		if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_EDGE)type = "EDGE";
		if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_GPRS)type = "GPRS";
		Toast.makeText(context, type, Toast.LENGTH_LONG).show();

		// Launch Activity RadioInfo
		Intent i = new Intent();
		i.setClassName( "com.android.settings", "com.android.settings.RadioInfo" );
		startActivity(i);
		
		// Close this Activity
		finish();
	}
}
