package com.wipro.srs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.service.AdminService;
import com.wipro.srs.util.User;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	User user;

	@RequestMapping(value = "/schedule_add", method = RequestMethod.GET)
	public String setScheduleForm(Model model) {
		System.out.println("1");
		ScheduleBean sb = new ScheduleBean();
		model.addAttribute("sb", sb);

		ArrayList<ShipBean> shipList = adminService.viewByAllShips();
		ArrayList<String> shipIds = new ArrayList<String>();

		for (int i = 0; i < shipList.size(); ++i) {
			shipIds.add(shipList.get(i).getShipId());
		}

		ArrayList<RouteBean> routeList = adminService.viewByAllRoute();
		ArrayList<String> routeIds = new ArrayList<String>();

		if (shipList == null || shipList.isEmpty()) {
			return "fail";
		}

		if (routeList == null || routeList.isEmpty()) {
			return "fail";
		}

		for (int i = 0; i < routeList.size(); ++i) {
			routeIds.add(routeList.get(i).getRouteID());
		}

		model.addAttribute("routeIds", routeIds);
		model.addAttribute("shipIds", shipIds);
		return "schedule_form";
	}

	@RequestMapping(value = "/schedule_add", method = RequestMethod.POST)
	public String processScheduleAdd(
			@ModelAttribute("sb") @Valid ScheduleBean sb, BindingResult result,
			Model model) {
		System.out.println("2");
		if (result.hasErrors()) {
			System.out.println("3");
			System.out.println(result.getAllErrors());
			// ///////////////////////////////////////////////////////////////////
			ArrayList<ShipBean> shipList = adminService.viewByAllShips();
			ArrayList<String> shipIds = new ArrayList<String>();

			for (int i = 0; i < shipList.size(); ++i) {
				shipIds.add(shipList.get(i).getShipId());
			}

			ArrayList<RouteBean> routeList = adminService.viewByAllRoute();
			ArrayList<String> routeIds = new ArrayList<String>();

			for (int i = 0; i < routeList.size(); ++i) {
				routeIds.add(routeList.get(i).getRouteID());
			}

			model.addAttribute("routeIds", routeIds);
			model.addAttribute("shipIds", shipIds);
			// //////////////////////////////////////////////////////////////////
			return "schedule_form";
		}
		
		

		/////
		Date enteredDate = sb.getStartDate();
		System.out.println("entered date to modify...." + enteredDate);
		System.out.println(enteredDate.before(new Date()));

		if (enteredDate.before(new Date())) {
			System.out.println("before....");
			model.addAttribute("failmsg",
					"Schedule cannot be entered for previous date....");
			return "fail";
		}
		//////

		
		
		String s = adminService.addSchedule(sb);

		System.out.println("4");
		if (s.equals("SUCCESS")) {
			model.addAttribute("succmsg", "Schedule added successfully......");
			return "Success";
		} else {
			model.addAttribute("failmsg",
					"Schedule was not added successfully......");
			return "failure";
		}
	}

	@RequestMapping(value = "/schedule_modify", method = RequestMethod.GET)
	public String setScheduleModifyForm(@RequestParam("value") String id,
			Model model) {
		ScheduleBean sb1 = new ScheduleBean();
		System.out.println(id);

		// model.addAttribute("id", id);
		model.addAttribute("sb1", sb1);
		sb1.setScheduleID(id);
		model.addAttribute("sb1", sb1);
		return "modifyschedule_form";
	}

	@RequestMapping(value = "/schedule_modify", method = RequestMethod.POST)
	public String processScheduleModify(
			@Valid @ModelAttribute("sb1") ScheduleBean sb1,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute(model);
			return "modifyschedule_form";
		}

		
		
		/////
			Date enteredDate = sb1.getStartDate();
			System.out.println("entered date to modify...." + enteredDate);
			System.out.println(enteredDate.before(new Date()));

			if (enteredDate.before(new Date())) {
				System.out.println("before....");
				model.addAttribute("failmsg",
						"Schedule cannot be entered for previous date....");
				return "fail";
			}
			//////
			
		System.out.println(sb1.getScheduleID());
		System.out.println(sb1.getRouteID());
		boolean b = adminService.modifySchedule(sb1);
		// model.addAttribute("sb1", sb1);
		if (b) {
			model.addAttribute("succmsg",
					"Schedule modified successfully......");
			return "Success";
		} else {
			model.addAttribute("failmsg",
					"Schedule wasd not modified successfully......");
			return "failure";
		}
	}

	@RequestMapping(value = "/schedule_delete", method = RequestMethod.GET)
	public String setScheduleDeleteForm(Model model) {

		// model.addAttribute("sb",s);
		return "schedule_viewbyId";
		// model.addAttribute("listid", listid);

	}

	@RequestMapping(value = "/schedule_delete", method = RequestMethod.POST)
	// @RequestMapping(value="/schedule_delete")
	public String processScheduleDelete(@RequestParam("delete") String[] listd,
			Model model) {
		System.out.println(listd.length);
		int i;
		ArrayList<String> listid = new ArrayList<String>();
		for (i = 0; i < listd.length; i++) {
			listid.add(listd[i]);
		}
		int n = adminService.removeSchedule(listid);
		System.out.println("controller recieved n= " + n);

		if (n > 0) {
			System.out.println("Success in controller for n= " + n);
			model.addAttribute("succmsg", "Schedule deleted successfully......");
			return "Success";
		} else {
			model.addAttribute("failmsg",
					"Schedule was not deleted successfully......");
			System.out.println("controller n=0.............................");
			return "failure";
		}

	}

	/*
	 * @RequestMapping(value = "/schedule_delete", method = RequestMethod.POST)
	 * // @RequestMapping(value="/schedule_delete") public String
	 * processScheduleDeleteId(
	 * 
	 * @RequestParam("delete1") String[] listd) {
	 * System.out.println(listd.length); int i; ArrayList<String> listid = new
	 * ArrayList<String>(); for (i = 0; i < listd.length; i++) {
	 * listid.add(listd[i]); } int n = adminService.removeSchedule(listid); if
	 * (n > 0) { return "Success"; } else { return "failure"; }
	 * 
	 * }
	 */

	@RequestMapping(value = "/schedule_viewall", method = RequestMethod.GET)
	public String processScheduleViewAll(Model model) {

		ArrayList<ScheduleBean> list = adminService.viewByAllSchedule();
		model.addAttribute("list", list);
		if (list == null) {
			model.addAttribute("failmsg", "Sorry, Empty Records......");
			return "failure";
		} else {

			return "schedule_viewall";
		}
	}

	@RequestMapping(value = "/schedule_viewbyId", method = RequestMethod.GET)
	public String setScheduleViewById(Model model) {
		ScheduleBean sb2 = new ScheduleBean();

		ArrayList<ScheduleBean> scheduleList = adminService.viewByAllSchedule();
		ArrayList<String> scheduleIdList = new ArrayList<String>();
		for (int i = 0; i < scheduleList.size(); ++i) {
			scheduleIdList.add(scheduleList.get(i).getScheduleID());
			System.out.println(scheduleList.get(i).getScheduleID());
		}
		model.addAttribute("scheduleIdList", scheduleIdList);
		model.addAttribute("sb2", sb2);
		return "viewschedule_id";
	}

	@RequestMapping(value = "/schedule_viewbyId", method = RequestMethod.POST)
	public String processScheduleViewId(
			@ModelAttribute("sb2") ScheduleBean sb2, Model model) {

		System.out
				.println("................................scheduleid recieved in admin controller ="
						+ sb2.getScheduleID());
		ScheduleBean s = adminService.viewByScheduleId(sb2.getScheduleID());
		model.addAttribute("sb2", s);
		if (s == null) {
			model.addAttribute("succmsg", "Sorry, Empty Recrods......");
			return "failure";
		} else {
			model.addAttribute("sb", s);
			return "schedule_viewbyId";// /////////////////////////////////////////////////////////////////////////
			// ///////////////////////////////////// return paage succeess
			// ?????????????????????????
		}
	}

	/*
	 * @RequestMapping(value="/route_viewall",method=RequestMethod.GET) public
	 * String processRouteViewAll(Model model){
	 * 
	 * ArrayList<RouteBean> list1=adminService.viewByAllRoute();
	 * model.addAttribute("list1", list1); if(list1==null){ return "failure"; }
	 * else{ return "route_viewall"; } }
	 */

	@RequestMapping(value = "/route_viewall", method = RequestMethod.GET)
	public String modifyrouteget(Model model) {
		List<RouteBean> list = adminService.viewByAllRoute();
		if (list == null) {
			model.addAttribute("failmsg", "Sorry, Empty Records......");
			return "failure";
		}
		model.addAttribute("list1", list);
		return "route_viewall";
	}

	@RequestMapping(value = "/route_viewbyId", method = RequestMethod.GET)
	public String setRouteViewById(Model model) {
		RouteBean rb = new RouteBean();

		ArrayList<RouteBean> routeList = adminService.viewByAllRoute();
		if (routeList == null || routeList.size() == 0) {
			System.out.println("No routes.....");
			model.addAttribute("failmsg", "Sorry, empty Records......");
			return "failure";
		}
		ArrayList<String> rids = new ArrayList<String>();
		for (int i = 0; i < routeList.size(); ++i) {
			rids.add(routeList.get(i).getRouteID());
		}
		model.addAttribute("rids", rids);
		model.addAttribute("rb", rb);
		return "viewroute_id";
	}

	@RequestMapping(value = "/route_viewbyId", method = RequestMethod.POST)
	public String processRouteViewId(@ModelAttribute("rb") RouteBean rb,
			Model model) {

		RouteBean s = adminService.viewByRouteId(rb.getRouteID());
		if (s == null) {
			model.addAttribute("failmsg", "Sorry, Empty Records......");
			return "failure";
		} else {
			model.addAttribute("rb", s);
			return "route_viewbyId";
		}
	}

	@RequestMapping(value = "/viewpassenger", method = RequestMethod.GET)
	public String setPassengerView(Model model) {
		ScheduleBean sb3 = new ScheduleBean();
		model.addAttribute("sb3", sb3);

		ArrayList<ScheduleBean> scheduleList = adminService.viewByAllSchedule();
		ArrayList<String> sidList = new ArrayList<String>();

		for (int i = 0; i < scheduleList.size(); ++i) {
			ScheduleBean scheduleBean = scheduleList.get(i);
			Date schdate = scheduleBean.getStartDate();
			Date current = new Date();

			if (schdate.compareTo(current) != -1) // future and current only...
			{
				sidList.add(scheduleBean.getScheduleID());
			}
		}

		model.addAttribute("sidList", sidList);
		return "passenger_view";
	}

	@RequestMapping(value = "/viewpassenger", method = RequestMethod.POST)
	public String processPassengerView(@ModelAttribute("sb3") ScheduleBean sb3,
			Model model) {

		ArrayList<PassengerBean> list2 = adminService.viewPasengersByShip(sb3
				.getScheduleID());
		model.addAttribute("list2", list2);
		if (list2 == null) {
			model.addAttribute("failmsg", "Sorry, Empty Records......");
			return "failure";
		} else {
			return "viewpassenger";
		}
	}

	/*
	 * @RequestMapping(value="/ModifyShip",method = RequestMethod.GET) public
	 * String addshipget(Model model){ ShipBean shipbean = new ShipBean();
	 * model.addAttribute("ModifyShip", shipbean); return "ModifyShip"; }
	 * 
	 * @RequestMapping( value="/ModifyShip",method = RequestMethod.POST) public
	 * void addshippost(@ModelAttribute("ModifyShip") ShipBean shipbean){
	 * adminService.addShip(shipbean); }
	 */
	@RequestMapping(value = "/ModifyShip", method = RequestMethod.GET)
	public String addshipget(Model model) {
		ShipBean shipbean = new ShipBean();
		model.addAttribute("ModifyShip", shipbean);
		return "ModifyShip";
	}

	@RequestMapping(value = "/ModifyShip", method = RequestMethod.POST)
	public String addshippost(
			@ModelAttribute("ModifyShip") @Valid ShipBean shipbean,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "ModifyShip";
		}
		if (adminService.addShip(shipbean).equals("SUCCESS")) {
			model.addAttribute("succmsg", "Ship added successfully......");
			return "Success";
		} else {
			model.addAttribute("failmsg",
					"Ship was not added successfully......");
			return "failure";
		}
	}

	@RequestMapping(value = "/ModifyShip1", method = RequestMethod.GET)
	public String modifyshipget(@RequestParam("value") String id, Model model) {

		ShipBean shipbean = new ShipBean();

		model.addAttribute("ModifyShip1", shipbean);
		shipbean.setShipId(id);
		model.addAttribute("ModifyShip1", shipbean);

		return "ModifyShip1";
	}

	@RequestMapping(value = "/ModifyShip1", method = RequestMethod.POST)
	public String modifyshippost(
			@ModelAttribute("ModifyShip1") ShipBean shipbean, Model model) {
		if (adminService.modifyShip(shipbean) == true) {
			model.addAttribute("succmsg", "Ship modified successfully......");
			return "Success";
		} else {
			model.addAttribute("failmsg",
					"Ship was not modified successfully......");
			return "failure";
		}
	}

	/*
	 * @RequestMapping(value="/DeleteByShipId",method = RequestMethod.GET)
	 * public String deleteshipget(Model model){ ShipBean shipbean = new
	 * ShipBean(); model.addAttribute("ModifyShip", shipbean); return
	 * "DeletByShipId"; }
	 * 
	 * @RequestMapping( value="/DeleteByShipId",method = RequestMethod.POST)
	 * public void deleteshippost(@ModelAttribute("delete") ArrayList<String>
	 * ShipId){ adminService.removeShip(ShipId); }
	 */
	@RequestMapping(value = "/DeleteByShipId", method = RequestMethod.GET)
	public String deleteshipget(Model model) {
		ShipBean shipbean = new ShipBean();
		model.addAttribute("DeleteByShipId", shipbean);
		return "DeleteByShipId";
	}

	@RequestMapping(value = "/DeleteByShipId", method = RequestMethod.POST)
	public String deleteshippost(@RequestParam("delete") String[] shipId,
			Model model) {

		ArrayList<String> shipIdarr = new ArrayList<String>();
		for (int i = 0; i < shipId.length; i++) {
			shipIdarr.add(shipId[i]);

		}
		// si.removeShip(shipIdarr);
		if (adminService.removeShip(shipIdarr) == 0) {
			model.addAttribute("failmsg",
					"Ship was not deleted successfully......");
			return "failure";
		} else {
			model.addAttribute("succmsg", "Ship deleted successfully......");
			return "Success";
		}
	}

	/*
	 * @RequestMapping(value="/ViewByShipId",method = RequestMethod.GET) public
	 * String viewshipget(Model model){ ShipBean shipbean = new ShipBean();
	 * model.addAttribute("ViewByShipId", shipbean); return "ViewByShipId";
	 * 
	 * }
	 * 
	 * @RequestMapping( value="/ViewByShipId",method = RequestMethod.POST)
	 * public void viewshippost(@ModelAttribute("ModifyShip") ShipBean
	 * shipbean){ adminService.viewByShipId(shipbean.getShipId()); }
	 */
	@RequestMapping(value = "/ViewByShipId", method = RequestMethod.GET)
	public String viewshipget(Model model) {
		ShipBean shipbean = new ShipBean();

		ArrayList<ShipBean> shiplist = adminService.viewByAllShips();
		ArrayList<String> shipidlist = new ArrayList<String>();
		if (shiplist == null || shiplist.size() == 0) {
			System.out.println("Empty listt !!!!!");
			model.addAttribute("failmsg", "Sorry, Empty Records......");
			return "failure";
		}

		for (int i = 0; i < shiplist.size(); ++i) {
			shipidlist.add(shiplist.get(i).getShipId());
		}
		model.addAttribute("shipidlist", shipidlist);
		model.addAttribute("ViewByShipId", shipbean);
		return "ViewByShipId";

	}

	@RequestMapping(value = "/ViewByShipId", method = RequestMethod.POST)
	public String viewshippost(
			@ModelAttribute("ViewByShipId") ShipBean shipbean, Model model) {

		System.out.println("yyyyyyyyyyyyyyyyaaaaaaaaaaaaaaa    "
				+ shipbean.getShipId() + "\n");
		if (shipbean.getShipId() == null)
			return "ViewByShipId";
		if (shipbean.getShipId().equals(" "))
			return "ViewByShipId";
		ShipBean shipbean1 = adminService.viewByShipId(shipbean.getShipId());
		if (shipbean1 == null) {
			model.addAttribute("failmsg", "Sorry, Empty records......");
			return "failure";
		} else {

			model.addAttribute("ship", shipbean1);
			return "DisplayShip";
		}

	}

	/*
	 * @RequestMapping( value="/viewall",method = RequestMethod.GET) public void
	 * viewallship(Model model){ List<ShipBean> list =
	 * adminService.viewByAllShips(); for(ShipBean s: list){
	 * System.out.println(s.getShipId()); System.out.println(s.getShipName());
	 * System.out.println(s.getSeatingCapacity());
	 * System.out.println(s.getReservationCapacity()); }
	 * 
	 * }
	 */
	@RequestMapping(value = "/ViewAllShips", method = RequestMethod.GET)
	public String viewallship(Model model) {
		List<ShipBean> list = adminService.viewByAllShips();
		if (list == null) {
			model.addAttribute("failmsg", "Sorry, Empty Records......");
			return "failure";
		} else {
			/*
			 * for(ShipBean s: list){ System.out.println(s.getShipId());
			 * System.out.println(s.getShipName());
			 * System.out.println(s.getSeatingCapacity());
			 * System.out.println(s.getReservationCapacity()); }
			 */
			model.addAttribute("dispall", list);
			return "DispAllShip";
		}

	}

	/*
	 * @RequestMapping(value="/AddRoute",method = RequestMethod.GET) public
	 * String addrouteget(Model model){ RouteBean routebean = new RouteBean();
	 * model.addAttribute("AddRoute", routebean); return "AddRoute"; }
	 * 
	 * @RequestMapping( value="/AddRoute",method = RequestMethod.POST) public
	 * void addroutepost(@ModelAttribute("AddRoute") RouteBean routebean){
	 * adminService.addRoute(routebean); }
	 */
	@RequestMapping(value = "/AddRoute", method = RequestMethod.GET)
	public String addrouteget(Model model) {
		RouteBean routebean = new RouteBean();
		model.addAttribute("AddRoute", routebean);
		return "AddRoute";
	}

	@RequestMapping(value = "/AddRoute", method = RequestMethod.POST)
	public String addroutepost(
			@ModelAttribute("AddRoute") @Valid RouteBean routebean,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "AddRoute";
		}
		if (adminService.addRoute(routebean).equals("SUCCESS")) {
			model.addAttribute("succmsg", "Route added successfully......");
			return "Success";
		} else {
			model.addAttribute("failmsg",
					"Route was not added successfully......");
			return "failure";
		}
	}

	@RequestMapping(value = "/ViewByRouteId", method = RequestMethod.GET)
	public String viewrouteget(Model model) {
		RouteBean routebean = new RouteBean();
		model.addAttribute("ViewByRouteId", routebean);
		return "ViewByRouteId";
	}

	@RequestMapping(value = "/ViewByRouteId", method = RequestMethod.POST)
	public void viewroutepost(@ModelAttribute("AddRoute") RouteBean routebean) {
		adminService.viewByRouteId(routebean.getRouteID());
	}

	@RequestMapping(value = "/ModifyRoute", method = RequestMethod.GET)
	public String modifyrouteget(@RequestParam("value") String id, Model model) {

		RouteBean rb = new RouteBean();

		model.addAttribute("ModifyRoute", rb);
		rb.setRouteID(id);
		model.addAttribute("ModifyRoute", rb);

		return "ModifyRoute";
	}

	@RequestMapping(value = "/ModifyRoute", method = RequestMethod.POST)
	public String modifyshippost(
			@ModelAttribute("ModifyRoute") RouteBean routebean, Model model) {
		if (adminService.modifyRoute(routebean) == true) {
			model.addAttribute("succmsg", "Route modified successfully......");
			return "Success";
		}

		else {
			model.addAttribute("failmsg",
					"Route was not modified successfully......");
			return "failure";
		}

	}

	@RequestMapping(value = "/DeleteRoute", method = RequestMethod.GET)
	public String delrouteget(Model model) {
		RouteBean routebean = new RouteBean();
		model.addAttribute("DeleteRoute", routebean);
		return "DeleteRoute";
	}

	@RequestMapping(value = "/DeleteRoute", method = RequestMethod.POST)
	public String delroutepost(
			@ModelAttribute("DeleteRoute") RouteBean routebean, Model model) {
		System.out.println(routebean.getRouteID());
		if (adminService.removeRoute(routebean.getRouteID()) == 0) {
			model.addAttribute("failmsg",
					"Route was not deleted successfully......");
			return "failure";
		} else {
			model.addAttribute("succmsg", "Route deleted successfully......");
			return "Success";
		}
	}

}
