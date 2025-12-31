package com.puttysoftware.rulemazer.maze.xml;

import java.io.IOException;

import org.retropipes.diane.fileio.legacy.XLegacyDataReader;
import org.retropipes.diane.fileio.legacy.XLegacyDataWriter;

public interface XMLPrefixIO {
    void writePrefix(XLegacyDataWriter writer) throws IOException;

    int readPrefix(XLegacyDataReader reader) throws IOException;
}
