<template>
    <v-footer absolute class="pa-3" color="add1">
        <v-spacer></v-spacer>
        <div>&copy; {{ year }} &copy;</div>
    </v-footer>
</template>

<script>
    export default {
        data: () => ({
            year: new Date().getFullYear()
        })
    }
</script>

