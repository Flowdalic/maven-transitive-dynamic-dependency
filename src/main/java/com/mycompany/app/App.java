package com.mycompany.app;

import java.io.File;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

import org.jivesoftware.smack.SmackConfiguration;
import org.jxmpp.util.XmppStringUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String smackVersion = SmackConfiguration.getVersion();
        System.out.println("Smack version: " + smackVersion);

        ProtectionDomain jxmppProtectionDomain = XmppStringUtils.class.getProtectionDomain();
        CodeSource jxmppCodeSource = jxmppProtectionDomain.getCodeSource();
        URL jxmppCodeSourceUrl = jxmppCodeSource.getLocation();
        String jxmppFile = jxmppCodeSourceUrl.getFile();
        String jxmppJar = jxmppFile.substring(jxmppFile.lastIndexOf(File.separator) + 1, jxmppFile.length());
        String jxmppName = jxmppJar.substring(0, jxmppJar.length() - ".jar".length());
        String jxmppVersion = jxmppName.substring("jxmpp-core-".length(), jxmppName.length());
        System.out.println("jxmpp version: " + jxmppVersion);

        if (jxmppVersion == null || !jxmppVersion.startsWith("0.6")) {
            System.out.println("ERROR: jxmpp version does not start with '0.6' as expected. :(");
            System.exit(1);
        }
    }
}
