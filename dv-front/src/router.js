import Vue from 'vue'
import Router from 'vue-router'

import Index from './views/Index'
import About from './components/About'
import Contact from './components/Contact'
import Login from './components/Login'
import SignUp from './components/SignUp'

import NotFound from './views/NotFound'

import Main from './views/Main'
import ADashboard from './components/auth/ADashboard'
import ADraftInfo from './components/auth/ADraftInfo'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: "*",
            name: "NotFound",
            component: NotFound
        },
        {
            path: "/",
            name: "Index",
            component: Index,
            children: [
                {
                    path: "",
                    component: About,
                },
                {
                    path: "about",
                    component: About
                },
                {
                    path: "contact",
                    component: Contact
                },
                {
                    path: "login",
                    component: Login
                },
                {
                    path: "sign",
                    component: SignUp
                },
            ]
        },
        {
            path: "/main",
            name: "Main",
            component: Main,
            children: [
                {
                    path: "",
                    component: ADashboard
                },
                {
                    path: "draft",
                    component: ADraftInfo
                },
            ]
        },
        /*{
            path: "/main/dash",
            name: "Main",
            component: ADashboard
        },*/
    ]
});