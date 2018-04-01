package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;

import ua.training.electriberies.model.ElectricalApplianceUtil;

public class ShowDeviceCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		request.setAttribute("devices", ElectricalApplianceUtil.showAllDevises());
		request.setAttribute("totalPower", ElectricalApplianceUtil.showTotalPower());
		request.setAttribute("currentPower", ElectricalApplianceUtil.showCurrentPower());
		return "/showdevices.jsp";
	}

}
