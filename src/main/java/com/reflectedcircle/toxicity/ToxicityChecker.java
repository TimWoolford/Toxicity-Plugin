package com.reflectedcircle.toxicity;

import com.puppycrawl.tools.checkstyle.Checker;
import com.puppycrawl.tools.checkstyle.api.*;

import java.io.File;
import java.util.List;

public class ToxicityChecker {
    private final Checker checker;

    public ToxicityChecker(DataRegister<ToxicEntity> register) throws CheckstyleException {
        Configuration configuration = ConfigurationFactory.configurationFromFile("/toxicity.xml");

        checker = new Checker();
        checker.setModuleClassLoader(Thread.currentThread().getContextClassLoader());
        checker.configure(configuration);
        checker.addListener(new GraphingAuditListener(register));
    }

    public void process(List<File> files) throws Exception {
        checker.process(files);
    }

    private static class GraphingAuditListener implements AuditListener {
        public final DataRegister<ToxicEntity> register;

        public GraphingAuditListener(DataRegister<ToxicEntity> register) {
            this.register = register;
        }

        public void auditStarted(AuditEvent aEvt) {
        }

        public void auditFinished(AuditEvent aEvt) {
        }

        public void fileStarted(AuditEvent aEvt) {
        }

        public void fileFinished(AuditEvent aEvt) {
        }

        public void addException(AuditEvent aEvt, Throwable aThrowable) {
        }

        public void addError(AuditEvent aEvt) {
            LocalizedMessage message = aEvt.getLocalizedMessage();
            ToxicityType toxicityType = ToxicityType.forKey(message.getKey());

            ToxicEntity toxicEntity = new ToxicEntity(toxicityType, new SourceEntity(aEvt.getFileName()));

            register.enter(toxicEntity, toxicityType.getMagnitude());
        }
    }
}