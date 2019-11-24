<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-container>
        <v-toolbar app  color="add1">
            <v-toolbar-title class="headline text-uppercase">
                <span v-text="app_name"></span>
            </v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn flat to="/about"><span class="mr-2">About</span></v-btn>
            <v-btn flat to="/contact"><span class="mr-2">Contact</span></v-btn>
            <v-menu offset-y>
                <template v-slot:activator="{ on }">
                    <v-btn color="add1" v-on="on">{{menu[0].title + ' / ' + menu[1].title}}</v-btn>
                </template>
                <v-list >
                    <v-list-tile
                            v-for="(item, index) in menu"
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
    import constant from '../constant'

    export default {
        data: () => ({
            app_name: constant.data().APP_NAME,
            menu: [
                {title: 'Login In', route: '/login'},
                {title: 'Sign Up', route: '/sign'}
            ]
        }),
        methods: {
            toRedirect(url) {
                this.$router.push(url);
            },
        }
    }
</script>
