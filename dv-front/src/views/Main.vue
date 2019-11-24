<template>
    <v-container>
        <AMenu />
        <router-view />
    </v-container>
</template>

<script>
    import AMenu from '../components/auth/AMenu'

    export default {
        components: {
            AMenu
        }
    }
</script>
