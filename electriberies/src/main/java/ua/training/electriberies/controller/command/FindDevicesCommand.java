package ua.training.electriberies.controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.electriberies.model.ElectricalAppliance;
import ua.training.electriberies.model.ElectricalApplianceUtil;

public class FindDevicesCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		int powerFrom = Integer.valueOf(request.getParameter("powerFrom"));
		int powerTo = Integer.valueOf(request.getParameter("powerTo"));
		int voltageFrom = (request.getParameter("220") == null) ? 380 : 220;
		int voltageTo = (request.getParameter("380") == null) ? 220 : 380;
		List<ElectricalAppliance> filteredDevices = 
				ElectricalApplianceUtil.findDevises(powerFrom, powerTo, voltageFrom, voltageTo);
		request.setAttribute("findeddevices", filteredDevices);
		return "/finddevice.jsp";
	}

}
