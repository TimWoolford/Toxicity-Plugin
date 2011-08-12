package com.reflectedcircle.toxicity;

import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.PropertiesExpander;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;

import java.util.Map;
import java.util.Properties;

import static com.puppycrawl.tools.checkstyle.ConfigurationLoader.loadConfiguration;

public class ConfigurationFactory {

    public static Configuration configurationFromFile(String filename) throws CheckstyleException {
        return loadConfiguration(ConfigurationFactory.class.getResource(filename).getPath(), new PropertiesExpander(new Properties()));
    }

    public static Configuration programmaticConfiguration() {
        DefaultConfiguration configuration = new DefaultConfiguration("myConfig");
        configuration.addChild(new ToxicConfiguration("FileLength", 500));
        DefaultConfiguration treeWalker = new DefaultConfiguration("TreeWalker");
        treeWalker.addChild(new ToxicConfiguration("FileContentsHolder"));
        treeWalker.addChild(new ToxicConfiguration("MethodLength", 30));
        treeWalker.addChild(new ToxicConfiguration("ParameterNumber", 6));
        treeWalker.addChild(new ToxicConfiguration("MissingSwitchDefault"));
        treeWalker.addChild(new ToxicConfiguration("NestedIfDepth", 2));
        treeWalker.addChild(new ToxicConfiguration("NestedTryDepth", 2));
        treeWalker.addChild(new ToxicConfiguration("BooleanExpressionComplexity"));
        treeWalker.addChild(new ToxicConfiguration("ClassDataAbstractionCoupling", 10));
        treeWalker.addChild(new ToxicConfiguration("ClassFanOutComplexity", 30));
        treeWalker.addChild(new ToxicConfiguration("CyclomaticComplexity", 10));
        configuration.addChild(treeWalker);
        return configuration;
    }

    private static class ToxicConfiguration implements Configuration {

        private final DefaultConfiguration configuration;

        public ToxicConfiguration(String aName) {
            configuration = new DefaultConfiguration(aName);
        }

        public ToxicConfiguration(String aName, int value) {
            this(aName);
            configuration.addAttribute("max", Integer.toString(value));
        }

        public String[] getAttributeNames() {
            return configuration.getAttributeNames();
        }

        public String getAttribute(String aName) throws CheckstyleException {
            return configuration.getAttribute(aName);
        }

        public Configuration[] getChildren() {
            return configuration.getChildren();
        }

        public String getName() {
            return configuration.getName();
        }

        public Map<String, String> getMessages() {
            return configuration.getMessages();
        }
    }
}
