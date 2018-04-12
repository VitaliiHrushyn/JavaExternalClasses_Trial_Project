package ua.training.electriberies.controller.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.electriberies.model.entity.devices.Device;
import ua.training.electriberies.model.service.DeviceService;

public class ShowDeviceCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		List<Device> devices = DeviceService.getAllDevises();
		request.setAttribute("devices", devices);
		request.setAttribute("totalPower", DeviceService.showTotalPower(devices));
		request.setAttribute("currentPower", DeviceService.showCurrentPower(devices));
		return "/view/showdevices.jsp";
	}

}
