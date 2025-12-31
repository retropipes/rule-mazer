package com.puttysoftware.rulemazer.maze.xml;

import java.io.IOException;

import org.retropipes.diane.fileio.legacy.XLegacyDataReader;
import org.retropipes.diane.fileio.legacy.XLegacyDataWriter;

public interface XMLSuffixIO {
    void writeSuffix(XLegacyDataWriter writer) throws IOException;

    void readSuffix(XLegacyDataReader reader, int formatVersion) throws IOException;
}
