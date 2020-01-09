package com.test;

import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.Collection;

import ch.shamu.jsendnrdp.NRDPException;
import ch.shamu.jsendnrdp.NRDPServerConnectionSettings;
import ch.shamu.jsendnrdp.NagiosCheckSender;
import ch.shamu.jsendnrdp.domain.NagiosCheckResult;
import ch.shamu.jsendnrdp.domain.State;
import ch.shamu.jsendnrdp.impl.NagiosCheckSenderImpl;

public class NRDP {
    public static void main(String[] args) throws IOException, NRDPException {

        NRDPServerConnectionSettings nrdpConnectionSettings = new NRDPServerConnectionSettings(
                "http://127.0.0.1:81/nrdp/",
                "culaio239ncgklak",
                10_000);
        NagiosCheckSender resultSender = new NagiosCheckSenderImpl(nrdpConnectionSettings);
        NagiosCheckResult resultToSend = new NagiosCheckResult("Local", "test", State.CRITICAL, "lets go");
        Collection<NagiosCheckResult> resultsToSend = Lists.newArrayList();
        resultsToSend.add(resultToSend);
        resultSender.send(resultsToSend);
    }
}
