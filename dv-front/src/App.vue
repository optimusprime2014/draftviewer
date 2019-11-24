<template>
    <v-app>
        <router-view/>
        <Footer/>
    </v-app>
</template>

<script>
    import Footer from './components/Footer'

    export default {
        name: 'App',
        components: {
            Footer
        },
        props: {
            user: {},
        },
        data: () => ({}),
    }
</script>

<!--//TODO style lang="stylus" scoped>
    $color-pack = false

    @import './assets/stylus/main.styl'

    body
      background-color #00c853
</style-->