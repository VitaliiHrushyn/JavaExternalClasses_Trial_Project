package ua.training.electriberies.controller.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.electriberies.model.entity.devices.Device;
import ua.training.electriberies.model.service.DeviceService;

public class FindDevicesCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, NumberFormatException {
		request.setAttribute("login", request.getSession().getAttribute("login"));
		Integer powerFrom = Integer.valueOf(request.getParameter("powerFrom"));
		Integer powerTo = Integer.valueOf(request.getParameter("powerTo"));
		int[] voltages = new int[2];
		voltages[0] = (request.getParameter("220") == null) ? 0 : 220;
		voltages[1] = (request.getParameter("380") == null) ? 0 : 380;
		List<Device> devices;
		
//		if (powerFrom == null) {
//			devices = DeviceService.getAllDevises();
//		} else {		
			devices = DeviceService.findDevises(powerFrom, powerTo, voltages);
//		}
		request.setAttribute("devices", devices);
		request.setAttribute("totalPower", DeviceService.showTotalPower(devices));
		request.setAttribute("currentPower", DeviceService.showCurrentPower(devices));
		return "/view/showdevices.jsp";
	}

}
