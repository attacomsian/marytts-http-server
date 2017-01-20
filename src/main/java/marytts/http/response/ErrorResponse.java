/**
 * Copyright 2015 DFKI GmbH. All Rights Reserved. Use is subject to license
 * terms.
 *
 * This file is part of MARY TTS.
 *
 * MARY TTS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package marytts.http.response;

/**
 * Standard mary response model wrapper
 *
 */
public class ErrorResponse {

    private final Integer code; /*< The error code */

    private final String message; /*< The error message */

    private final String hint; /*< api hint */
    /**
     * Constructor which initialize the data structure
     *
     * @param code - the code value
     * @param message - the message
     */
    public ErrorResponse(Integer code, String message, String hint) {
        this.code = code;
        this.message = message;
        this.hint = hint;
    }

    /**
     * Accessor to get the code value
     *
     * @return the code
     */
    public Object getCode() {
        return code;
    }

    /**
     * Accessor to get the message value
     *
     * @return the message string
     */
    public String getMessage() {
        return message;
    }

    public String getHint() {
        return "Please use " + hint + "/help API endpoint to retreive all the available API endpoints.";
    } 
}
