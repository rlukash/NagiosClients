package com.test;

import com.googlecode.jsendnsca.Level;
import com.googlecode.jsendnsca.MessagePayload;
import com.googlecode.jsendnsca.NagiosException;
import com.googlecode.jsendnsca.NagiosPassiveCheckSender;
import com.googlecode.jsendnsca.NagiosSettings;
import com.googlecode.jsendnsca.builders.MessagePayloadBuilder;
import com.googlecode.jsendnsca.builders.NagiosSettingsBuilder;
import com.googlecode.jsendnsca.encryption.Encryption;

import java.io.IOException;

public class NSCA {
    public static void main(String[] args) throws IOException, NagiosException {
        //Wasn't tested yet
        NagiosSettings settings = new NagiosSettingsBuilder()
                .withNagiosHost("localhost")
                .withPort(8080)
                .withEncryption(Encryption.NONE)
                .create();

        MessagePayload payload = new MessagePayloadBuilder()
                .withHostname("hostname of machine sending check")
                .withLevel(Level.OK)
                .withServiceName("Service Name")
                .withMessage("should work if everything set up OK")
                .create();

        NagiosPassiveCheckSender sender = new NagiosPassiveCheckSender(settings);

        sender.send(payload);
    }
}
