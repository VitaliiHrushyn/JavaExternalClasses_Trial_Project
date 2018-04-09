package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;

public class ExceptionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        throw new RuntimeException("Generated exception");
    }
}
