package ua.training.electriberies.controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.electriberies.model.ElectricalApplianceUtil;
import ua.training.electriberies.model.entity.devices.ElectricalAppliance;

public class ShowDeviceCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		List<ElectricalAppliance> devices = ElectricalApplianceUtil.showAllDevises();
		request.setAttribute("devices", devices);
		request.setAttribute("totalPower", ElectricalApplianceUtil.showTotalPower(devices));
		request.setAttribute("currentPower", ElectricalApplianceUtil.showCurrentPower(devices));
		return "/showdevices.jsp";
	}

}
