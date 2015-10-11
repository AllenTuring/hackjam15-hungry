package com.hungrybears;

import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by allen on 10/10/2015.
 */
public class SharedPrefReader {
    SharedPreferences s;

    public SharedPrefReader(SharedPreferences s) {
        this.s = s;
    }

    private void throwNotExistsError(String key) throws NullPointerException {
        throw new NullPointerException("Shared preference \"" + key + "\" does not exist.");
    }

    private void existsTest(String key, Object c0, Object c1) {
        if (!c0.equals(c1)) {
            throwNotExistsError(key);
        }
    }

    private boolean getBoolean(String key) {
        boolean b0 = s.getBoolean(key, true);
        boolean b1 = s.getBoolean(key, false);
        if (b0 ^ b1) {
            throwNotExistsError(key);
        }
        return b0;
    }

    private int getInt(String key) {
        int i0 = s.getInt(key, 0);
        int i1 = s.getInt(key, 1);
        if (i0 != i1) {
            throwNotExistsError(key);
        }
        return i0;
    }

    private float getFloat(String key) {
        float f0 = s.getFloat(key, 0);
        float f1 = s.getFloat(key, 1);
        if (f0 != f1) {
            throwNotExistsError(key);
        }
        return f0;
    }

    private long getLong(String key) {
        long L0 = s.getLong(key, 0L);
        long L1 = s.getLong(key, 1L);
        if (L0 != L1) {
            throwNotExistsError(key);
        }
        return L0;
    }

    private String getString(String key) {
        String s0 = s.getString(key, "");
        String s1 = s.getString(key, "stub");
        existsTest(key, s0, s1);
        return s0;
    }

    private Set<String> getStringSet(String key) {
        Set<String> ss0d = new TreeSet<String>();
        Set<String> ss1d = new TreeSet<String>();
        ss1d.add("stub");
        Set<String> ss0 = s.getStringSet(key, ss0d);
        Set<String> ss1 = s.getStringSet(key, ss1d);
        existsTest(key, ss0, ss1);
        return ss0;
    }

    private Map<String, ?> getAll() {
        return s.getAll();
    }
}
