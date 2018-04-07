package ua.training.electriberies.controller.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.electriberies.model.DeviceUtil;
import ua.training.electriberies.model.entity.devices.Device;

public class ShowDeviceCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		List<Device> devices = DeviceUtil.showAllDevises();
		request.setAttribute("devices", devices);
		request.setAttribute("totalPower", DeviceUtil.showTotalPower(devices));
		request.setAttribute("currentPower", DeviceUtil.showCurrentPower(devices));
		return "/showdevices.jsp";
	}

}
