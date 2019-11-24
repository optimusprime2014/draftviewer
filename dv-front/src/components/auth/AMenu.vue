<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-container>
        <v-toolbar app color="add1">
            <v-toolbar-title class="headline text-uppercase">
                <span v-text="user_appname"></span>
            </v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn flat to="/main"><span class="mr-2">Dashboard</span></v-btn>
            <v-menu offset-y>
                <template v-slot:activator="{ on }">
                    <v-btn color="add1" v-on="on">{{user_menu.name}}</v-btn>
                </template>
                <v-list>
                    <v-list-tile
                            v-for="(item, index) in user_menu.list"
                            :key="index"
                            @click=""
                            v-on:click="toRedirect(item.route)">
                        <v-list-tile-title>{{item.title}}</v-list-tile-title>
                    </v-list-tile>
                </v-list>
            </v-menu>
        </v-toolbar>
    </v-container>
</template>

<script>
    import constant from '../../constant'
    import App from '../../App'

    export default {
        data: () => ({
            user_appname: constant.data().APP_NAME + ': ' + App.props.user.login,
            user_menu: {
                name: 'My account',
                list: [
                    {title: 'Setting', route: '#'},
                    {title: 'Logout', route: '/'},
                ]
            }
        }),
        methods: {
            toRedirect(url) {
                this.$router.push(url);
            },
        }
    }
</script>
