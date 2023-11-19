package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class Task6 {
    private static final int LAST_PORT = 49152;

    private Task6() {

    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    public static void scanPorts() {
        System.out.println("Протокол\t\t" + "Порт\t" + "Сервис");
        for (int port = 0; port < LAST_PORT; port++) {
            if (checkServerPort(port) && !getServiceName(port).isEmpty()) {
                System.out.println("TCP\t\t\t\t" + port + "\t\t" + getServiceName(port));
            }
            if (checkDatagramSocket(port) && !getServiceName(port).isEmpty()) {
                System.out.println("UDP\t\t\t\t" + port + "\t\t" + getServiceName(port));
            }
        }
    }

    private static boolean checkServerPort(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            return false;
        } catch (IOException e) {
            return true;
        }
    }

    private static boolean checkDatagramSocket(int port) {
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            return false;
        } catch (IOException e) {
            return true;
        }
    }

    @SuppressWarnings("MagicNumber")
    private static String getServiceName(int port) {
        return switch (port) {
            case 135 -> "EPMAP";
            case 137 -> "NetBIOS Name Service";
            case 138 -> "NetBIOS Datagram Service";
            case 139 -> "NetBIOS Session Service";
            case 445 -> "Microsoft-DS Active Directory";
            case 843 -> "Adobe Flash";
            case 1900 -> "Simple Service Discovery Protocol (SSDP)";
            case 3702 -> "Dynamic Web Services Discovery";
            case 5353 -> "Multicast DNS";
            case 5355 -> "Link-Local Multicast Name Resolution (LLMNR)";
            case 17500 -> "Dropbox";
            case 27017 -> "MongoDB";
            default -> "";
        };
    }
}

