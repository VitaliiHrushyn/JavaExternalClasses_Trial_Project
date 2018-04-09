package ua.training.electriberies.controller.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.electriberies.model.entity.devices.Device;
import ua.training.electriberies.model.service.DeviceService;

public class FindDevicesCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, NumberFormatException {
		int powerFrom = Integer.valueOf(request.getParameter("powerFrom"));
		int powerTo = Integer.valueOf(request.getParameter("powerTo"));
		int voltageFrom = (request.getParameter("220") == null) ? 380 : 220;
		int voltageTo = (request.getParameter("380") == null) ? 220 : 380;
		List<Device> filteredDevices = 
				DeviceService.findDevises(powerFrom, powerTo, voltageFrom, voltageTo);
		request.setAttribute("findeddevices", filteredDevices);
		request.setAttribute("totalPower", DeviceService.showTotalPower(filteredDevices));
		request.setAttribute("currentPower", DeviceService.showCurrentPower(filteredDevices));
		return "/view/finddevice.jsp";
	}

}
