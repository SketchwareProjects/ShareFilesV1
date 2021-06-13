package dev.gerges.ShareFiles;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.net.Inet4Address;
public class getPublicIpAddress    
{

    private static String ip;
    public static String main()throws Exception{

        String res = null;
        
            String localhost = InetAddress.getLocalHost().getHostAddress();
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) e.nextElement();
                if(ni.isLoopback())
                    continue;
                if(ni.isPointToPoint())
                    continue;
                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress address = (InetAddress) addresses.nextElement();
                    if(address instanceof Inet4Address) {
                        String ip = address.getHostAddress();
                        if(!ip.equals(localhost))
                            res = ip;
                    }
                }
            }
        
        
        return res;
        
    }
    
}