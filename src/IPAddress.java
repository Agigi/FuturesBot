/*
 * TradingBot - A Java Trading system..
 * 
 * Copyright (C) 2013 Philipz (philipzheng@gmail.com)
 * http://www.tradingbot.com.tw/
 * http://www.facebook.com/tradingbot
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Apache License, Version 2.0 ���v���廡��
 * http://www.openfoundry.org/licenses/29
 * �Q�� Apache-2.0 �{��������u���q�ȳW�w
 * http://www.openfoundry.org/tw/legal-column-list/8950-obligations-of-apache-20
 */
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IPAddress {
 public void  getInterfaces (){
      try {
         Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();

         while(e.hasMoreElements()) {
            NetworkInterface ni = (NetworkInterface) e.nextElement();
            System.out.println("Net interface: "+ni.getName());

            Enumeration<InetAddress> e2 = ni.getInetAddresses();

            while (e2.hasMoreElements()){
               InetAddress ip = (InetAddress) e2.nextElement();
               System.out.println("IP address: "+ ip.toString());
            }
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

	public String getPPPIp() {
		String ipaddress = null;
		try {
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();

			while (e.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e.nextElement();
				if (ni.getName().equals("ppp0")) {
					//System.out.println("Net interface: " + ni.getName());
					Enumeration<InetAddress> e2 = ni.getInetAddresses();
					while (e2.hasMoreElements()) {
						InetAddress ip = (InetAddress) e2.nextElement();
						ipaddress = "IP address: " + ip.toString();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipaddress;
	}

   public static void main(String[] args) {
    IPAddress ip = new IPAddress();
    //ip.getInterfaces();
    ip.getPPPIp();
   }
}