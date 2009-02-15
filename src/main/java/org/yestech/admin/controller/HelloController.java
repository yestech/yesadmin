/*
 *
 * Original Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */
package org.yestech.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author $Author: $
 * @version $Revision: $
 */
@Controller
@RequestMapping("/hello.yes")
public class HelloController
{
    private String  message;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello()
    {
        return "hello";
    }
}
