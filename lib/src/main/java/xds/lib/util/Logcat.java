/*
 * Copyright 2021 Ilya V Malakhov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xds.lib.util;

import android.os.Build;
import android.util.Log;

/**
 * The wrapper of {@link Log} helps to print logs related of build variant, as user, debug, etc...
 */
public final class Logcat {

    private static volatile boolean debuggable = false;

    private static final boolean DEBUG = debuggable || !Build.TYPE.equals("user") ||
            Build.DEVICE.startsWith("generic");

    /**
     * Override default debuggable policy.
     */
    public static void setDebuggable(Boolean isDebuggable) {
        debuggable = isDebuggable;
    }

    /**
     * Send a {@link Log#VERBOSE} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void v(String tag, String msg) {
        print(Log.VERBOSE, tag, msg);
    }

    /**
     * Send a {@link Log#VERBOSE} log formatting message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format format A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args   Arguments referenced by the format specifiers in the format string
     */
    public static void v(String tag, String format, Object... args) {
        print(Log.VERBOSE, tag, format, args);
    }

    /**
     * Send a {@link Log#DEBUG} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void d(String tag, String msg) {
        print(Log.DEBUG, tag, msg);
    }

    /**
     * Send a {@link Log#DEBUG} log formatting message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format format A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args   Arguments referenced by the format specifiers in the format string
     */
    public static void d(String tag, String format, Object... args) {
        print(Log.DEBUG, tag, format, args);
    }

    /**
     * Send a {@link Log#INFO} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void i(String tag, String msg) {
        print(Log.INFO, tag, msg);
    }

    /**
     * Send a {@link Log#INFO} log formatting message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format format A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args   Arguments referenced by the format specifiers in the format string
     */
    public static void i(String tag, String format, Object... args) {
        print(Log.INFO, tag, format, args);
    }

    /**
     * Send a {@link Log#WARN} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void w(String tag, String msg) {
        print(Log.WARN, tag, msg);
    }

    /**
     * Send a {@link Log#WARN} log formatting message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format format A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args   Arguments referenced by the format specifiers in the format string
     */
    public static void w(String tag, String format, Object... args) {
        print(Log.WARN, tag, format, args);
    }

    /**
     * Send a {@link Log#WARN} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static void w(String tag, Throwable tr, String msg) {
        print(Log.WARN, tag, tr, msg);
    }

    /**
     * Send a {@link Log#WARN} log formatting message and log the exception.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param tr     An exception to log
     * @param format format A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args   Arguments referenced by the format specifiers in the format string
     */
    public static void w(String tag, Throwable tr, String format, Object args) {
        print(Log.WARN, tag, tr, format, args);
    }

    /**
     * Send a {@link Log#ERROR} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void e(String tag, String msg) {
        print(Log.ERROR, tag, msg);
    }

    /**
     * Send a {@link Log#ERROR} log formatting message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format format A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args   Arguments referenced by the format specifiers in the format string
     */
    public static void e(String tag, String format, Object... args) {
        print(Log.ERROR, tag, format, args);
    }

    /**
     * Send a {@link Log#WARN} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static void e(String tag, Throwable tr, String msg) {
        print(Log.ERROR, tag, tr, msg);
    }

    /**
     * Send a {@link Log#WARN} log formatting message and log the exception.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param tr     An exception to log
     * @param format format A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args   Arguments referenced by the format specifiers in the format string
     */
    public static void e(String tag, Throwable tr, String format, Object args) {
        print(Log.ERROR, tag, tr, format, args);
    }

    /**
     * Print log to output.
     *
     * @param priority The priority type of this log message
     * @param tag      Used to identify the source of a log message. It usually identifies
     *                 the class or activity where the log call occurs.
     * @param msg      The message you would like logged.
     */
    private static void print(int priority, String tag, String msg) {
        if (!DEBUG && !Log.isLoggable(tag, priority)) {
            return;
        }
        Log.println(priority, tag, msg);
    }

    /**
     * Print log with formatting message to output.
     *
     * @param priority The priority or type of this log message
     * @param tag      Used to identify the source of a log message. It usually identifies
     *                 the class or activity where the log call occurs.
     * @param format   format A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args     Arguments referenced by the format specifiers in the format string
     */
    private static void print(int priority, String tag, String format, Object... args) {
        if (!DEBUG && !Log.isLoggable(tag, priority)) {
            return;
        }
        Log.println(priority, tag, String.format(format, args));
    }

    /**
     * Print log with stack trace of exception to output.
     *
     * @param priority The priority or type of this log message
     * @param tag      Used to identify the source of a log message. It usually identifies
     *                 the class or activity where the log call occurs.
     * @param tr       An exception to log
     * @param msg      The message you would like logged.
     */
    private static void print(int priority, String tag, Throwable tr, String msg) {
        if (!DEBUG && !Log.isLoggable(tag, priority)) {
            return;
        }
        Log.println(priority, tag, msg + "\n" + parseStackTrace(tr));
    }

    /**
     * Print log with stack trace of exception and formatting message to output.
     *
     * @param priority The priority or type of this log message
     * @param tag      Used to identify the source of a log message. It usually identifies
     *                 the class or activity where the log call occurs.
     * @param tr       An exception to log
     * @param format   format A <a href="../util/Formatter.html#syntax">format string</a>
     * @param args     Arguments referenced by the format specifiers in the format string
     */
    private static void print(int priority, String tag, Throwable tr, String format, Object... args) {
        if (!DEBUG && !Log.isLoggable(tag, priority)) {
            return;
        }
        Log.println(priority, tag, String.format(format, args) + "\n" + parseStackTrace(tr));
    }

    /**
     * Parse stack trace of the exception for good look in log output.
     *
     * @param tr An exception
     * @return String prepared for log print, each trace separated by new line.
     */
    private static String parseStackTrace(Throwable tr) {
        if (tr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(tr.toString()).append("\n");
        for (StackTraceElement element : tr.getStackTrace()) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }
}
