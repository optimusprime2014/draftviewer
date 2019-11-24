<template>
    <v-footer absolute class="pa-3" color="add1">
        <v-spacer></v-spacer>
        <div>FT Studio &copy; {{ year }}</div>
    </v-footer>
</template>

<script>
    export default {
        data: () => ({
            year: new Date().getFullYear()
        })
    }
</script>

