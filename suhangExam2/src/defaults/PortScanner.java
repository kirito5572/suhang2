package defaults;

import java.net.*;
import java.util.*;
import java.util.concurrent.*;
public class PortScanner {
	public static Future<ScanResult> portIsOpen(final ExecutorService es, final String ip, final int port, final int timeout) {
		return es.submit(new Callable<ScanResult>() {
			public ScanResult call(){
				try {
					Socket socket = new Socket();
					socket.connect(new InetSocketAddress(ip, port), timeout);
					socket.close();
					return new ScanResult(port, true);
				} catch (Exception e) {
					return new ScanResult(port,false);
				}
			}
		});
	}

}
