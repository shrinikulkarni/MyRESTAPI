package com.example.demo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;

public class CustomPrettyPrinter extends DefaultPrettyPrinter {

    public CustomPrettyPrinter() {
        super();
        _objectFieldValueSeparatorWithSpaces = ": ";
    }

    @Override
    public void writeStartArray(JsonGenerator g) throws IOException {
        g.writeRaw('[');
        g.writeRaw('\n');
        _nesting++;
        _arrayIndenter.writeIndentation(g, _nesting);
    }

    @Override
    public void writeEndArray(JsonGenerator g, int nrOfValues) throws IOException {
        _nesting--;
        if (nrOfValues > 0) {
            _arrayIndenter.writeIndentation(g, _nesting);
        }
        g.writeRaw('\n');
        _arrayIndenter.writeIndentation(g, _nesting);
        g.writeRaw(']');
    }

    @Override
    public void writeStartObject(JsonGenerator g) throws IOException {
        g.writeRaw('{');
        //g.writeRaw('\n');
        _nesting++;
        _objectIndenter.writeIndentation(g, _nesting);
    }

    @Override
    public void writeEndObject(JsonGenerator g, int nrOfEntries) throws IOException {
        _nesting--;
        if (nrOfEntries > 0) {
            _objectIndenter.writeIndentation(g, _nesting);
        }
        //g.writeRaw('\n');
        _objectIndenter.writeIndentation(g, _nesting);
        g.writeRaw('}');
    }

    @Override
    public DefaultPrettyPrinter createInstance() {
        return new CustomPrettyPrinter();
    }

    @Override
    public void writeObjectEntrySeparator(JsonGenerator g) throws IOException {
        g.writeRaw(',');
        //g.writeRaw('\n');
        _objectIndenter.writeIndentation(g, _nesting);
    }

    @Override
    public void writeArrayValueSeparator(JsonGenerator g) throws IOException {
        g.writeRaw(',');
        //g.writeRaw('\n');
        _arrayIndenter.writeIndentation(g, _nesting);
    }
}