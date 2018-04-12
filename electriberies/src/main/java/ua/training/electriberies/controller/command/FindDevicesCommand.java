package ua.training.electriberies.controller.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.electriberies.model.entity.devices.Device;
import ua.training.electriberies.model.service.DeviceService;

public class FindDevicesCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, NumberFormatException {
		Integer powerFrom = Integer.valueOf(request.getParameter("powerFrom"));
		Integer powerTo = Integer.valueOf(request.getParameter("powerTo"));
		Integer voltageFrom = (request.getParameter("220") == null) ? 380 : 220;
		Integer voltageTo = (request.getParameter("380") == null) ? 220 : 380;
		List<Device> devices;
		
		if (powerFrom == null) {
			devices = DeviceService.getAllDevises();
		} else {		
			devices = DeviceService.findDevises(powerFrom, powerTo, voltageFrom, voltageTo);
		}
		request.setAttribute("devices", devices);
		request.setAttribute("totalPower", DeviceService.showTotalPower(devices));
		request.setAttribute("currentPower", DeviceService.showCurrentPower(devices));
		return "/view/showdevices.jsp";
	}

}
