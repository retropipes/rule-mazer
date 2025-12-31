/*  RuleMazer: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: rulemazer@puttysoftware.com
 */
package com.puttysoftware.rulemazer;

import org.retropipes.diane.Diane;
import org.retropipes.diane.gui.dialog.CommonDialogs;
import org.retropipes.diane.integration.Integration;

import com.puttysoftware.rulemazer.prefs.PreferencesLauncher;

public class Main {
    // Constants
    private static Application application;
    private static final String PROGRAM_NAME = "RuleMazer";
    private static final String ERROR_MESSAGE = "Perhaps a bug is to blame for this error message.\n"
	    + "Include the debug log with your bug report.\n" + "Email bug reports to: rulemazer@puttysoftware.com\n"
	    + "Subject: RuleMazer Bug Report";
    private static final String ERROR_TITLE = "RuleMazer Error";

    // Methods
    public static Application getApplication() {
	return Main.application;
    }

    public static void logError(final Throwable t) {
	CommonDialogs.showErrorDialog(ERROR_MESSAGE, ERROR_TITLE);
	Diane.handleError(t);
    }

    public static void main(final String[] args) {
	try {
	    // Install error handler
	    Diane.installDefaultErrorHandler(PROGRAM_NAME);
	    // Integrate with host platform
	    final Integration platform = Integration.integrate();
	    Main.application = new Application();
	    Main.application.postConstruct();
	    Main.application.playLogoSound();
	    Main.application.getGUIManager().showGUI();
	    // Register platform hooks
	    platform.setAboutHandler(Main.application.getAboutDialog());
	    platform.setOpenFileHandler(Main.application.getMazeManager());
	    platform.setPreferencesHandler(new PreferencesLauncher());
	    platform.setQuitHandler(Main.application.getGUIManager());
	} catch (final Throwable t) {
	    Main.logError(t);
	}
    }
}
