package com.puttysoftware.rulemazer.maze.xml;

import java.io.IOException;

import org.retropipes.diane.fileio.legacy.XLegacyDataReader;
import org.retropipes.diane.fileio.legacy.XLegacyDataWriter;

import com.puttysoftware.rulemazer.Main;

public class XMLSuffixHandler implements XMLSuffixIO {
    @Override
    public void readSuffix(final XLegacyDataReader reader, final int formatVersion) throws IOException {
	Main.getApplication().getGameManager().loadGameHookXML(reader, formatVersion);
    }

    @Override
    public void writeSuffix(final XLegacyDataWriter writer) throws IOException {
	Main.getApplication().getGameManager().saveGameHookXML(writer);
    }
}
