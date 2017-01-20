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
package marytts.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class HelpController {

    private final RequestMappingHandlerMapping handlerMapping;

    @Autowired
    public HelpController(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    /**
     * Method used to set the current level of logger
     *
     * @return String all the available API end points
     * @throws Exception in case of failure to generate help
     */
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help() throws Exception {

        String endpoints = "Following are the available endpoints:<br/><br/>";
        for (RequestMappingInfo rm : this.handlerMapping.getHandlerMethods().keySet()) {
            endpoints += "<b>URL: " + rm.getPatternsCondition() + "</b><br>";
            endpoints += "Request Method: " + (rm.getMethodsCondition().toString().equals("[]") ? "[GET]" : rm.getMethodsCondition()) + "<br>";
            endpoints += "Params: " + rm.getParamsCondition() + "<br>";
            endpoints += "Consumes: " + rm.getConsumesCondition() + "<br><br/>";
        }
        return endpoints;
    }
}
