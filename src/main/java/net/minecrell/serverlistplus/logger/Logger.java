/*
 * ServerListPlus
 * Copyright (C) 2016, Minecrell <https://github.com/Minecrell>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.minecrell.serverlistplus.logger;

public interface Logger {

    boolean isDebugEnabled();

    void debug(String message);
    void debug(String message, Object... args);
    void debug(String message, Throwable t);

    boolean isInfoEnabled();

    void info(String message);
    void info(String message, Object... args);
    void info(String message, Throwable t);

    boolean isWarnEnabled();

    void warn(String message);
    void warn(String message, Object... args);
    void warn(String message, Throwable t);

    boolean isErrorEnabled();

    void error(String message);
    void error(String message, Object... args);
    void error(String message, Throwable t);

    default ReportedException report(Throwable t, String message) throws ReportedException {
        error(message, t);
        throw new ReportedException(message, t);
    }

    default ReportedException report(Throwable t, String message, Object... args) throws ReportedException {
        message = SimpleMessageFormatter.format(message, args);
        error(message, t);
        throw new ReportedException(message, t);
    }

}
