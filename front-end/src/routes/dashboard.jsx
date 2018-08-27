import ProblemsStudent from '../containers/ProblemsStudent.js'
import ProblemsTeacher from '../containers/ProblemsTeacher.js'


const dashboardRoutes = [
  {
    path: "/problems/student",
    name: "Problemas",
    icon: "pe-7s-graph",
    component: ProblemsStudent
  },
  {
    path: "/problems/teacher",
    name: "Problemas definidos",
    icon: "pe-7s-user",
    component: ProblemsTeacher
  }
];

export default dashboardRoutes;
