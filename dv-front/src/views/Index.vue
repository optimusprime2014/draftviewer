<template>
    <v-container>
        <Menu/>
        <ProgressBar/>
        <router-view/>
    </v-container>
</template>

<script>
    import Menu from '../components/Menu'
    import ProgressBar from '../components/ProgressBar'
    import App from '../App'

    export default {
        components: {
            Menu, ProgressBar
        },
        methods: {
            clear() {
                //clear data about current user
                App.props.user = {};
            },
        },
        mounted() {
            this.methods.clear();
        },
    }
</script>
