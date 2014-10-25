package com.example.practiceapp;

import com.example.practiceapp.DeviceListFragment.DeviceActionListener;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.ChannelListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MyWifiActivity extends Activity implements ChannelListener,
		DeviceActionListener {

	WifiP2pManager mManager;
	Channel channel;
	BroadcastReceiver broadcastReceiver = null;

	public static final String TAG = "wifidirectdemo";
	private WifiP2pManager manager;
	private boolean isWifiP2pEnabled = false;
	private boolean retryChannel = false;

	private final IntentFilter intentFilter = new IntentFilter();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_wifi);
		intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
		intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
		intentFilter
				.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
		intentFilter
				.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

		mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
		channel = mManager.initialize(this, getMainLooper(), null);
		broadcastReceiver = new WifiDirectBroadcastReceiver(mManager, channel,
				this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_wifi, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void setIsWifiP2pEnabled(boolean b) {
		// TODO Auto-generated method stub
		this.isWifiP2pEnabled = b;

	}

	public void resetData() {
		DeviceListFragment fragmentList = (DeviceListFragment) getFragmentManager()
				.findFragmentById(R.id.frag_list);
		DeviceDetailFragment fragmentDetail = (DeviceDetailFragment) getFragmentManager()
				.findFragmentById(R.id.frag_detail);
		if (fragmentList != null)
		{
			fragmentList.clearPeers();
		}
		if (fragmentDetail!=null)
		{
			fragmentList.clearPeers();
		}

	}

	@Override
	public void showDetails(WifiP2pDevice device) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelDisconnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void connect(WifiP2pConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChannelDisconnected() {
		// TODO Auto-generated method stub

	}
}
