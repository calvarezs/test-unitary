

const dashboardRoutes = [
  {
    path: "/dashboard",
    name: "Dashboard",
    icon: "pe-7s-graph"
  },
  {
    path: "/user",
    name: "User Profile",
    icon: "pe-7s-user"
  },
  {
    path: "/table",
    name: "Table List",
    icon: "pe-7s-note2"
  },
  {
    path: "/typography",
    name: "Typography",
    icon: "pe-7s-news-paper"
  },
  { path: "/icons", name: "Icons", icon: "pe-7s-science" },
  { path: "/maps", name: "Maps", icon: "pe-7s-map-marker" },
  {
    path: "/notifications",
    name: "Notifications",
    icon: "pe-7s-bell"
  },
  {
    upgrade: true,
    path: "/upgrade",
    name: "Upgrade to PRO",
    icon: "pe-7s-rocket"
  },
  { redirect: true, path: "/", to: "/dashboard", name: "Dashboard" }
];

export default dashboardRoutes;
