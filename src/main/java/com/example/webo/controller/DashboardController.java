package com.example.webo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DashboardController {


@GetMapping("/Dashboard")
public String Dashboard() {
  return "Dashboard";
}

@GetMapping("/DashboardLogin")
public String DashboardLogin() {
  return "DashboardLogin";
}

@GetMapping("/DashboardIndex")
public String DashboardIndex() {
  return "DashboardIndex";
}
}
