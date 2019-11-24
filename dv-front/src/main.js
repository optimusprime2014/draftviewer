import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import Vuetify from 'vuetify'
import router from './router'
import constant from './constant'

Vue.config.productionTip = false;

Vue.use(Vuetify, {
    theme: {
        /*default block*/
        primary: '#1976D2',
        secondary: '#424242',
        accent: '#82B1FF',
        error: '#FF5252',
        info: '#2196F3',
        success: '#4CAF50',
        warning: '#FFC107',

        /*custom block*/
        main: constant.data().COLOR.main,
        add1: constant.data().COLOR.add1,
        add2: constant.data().COLOR.add2,
        back: constant.data().COLOR.back,
    }
});

new Vue({
    router,
    render: h => h(App),
}).$mount('#app');
