<template>
    <v-progress-linear
            :value="value"
            :height="height"
            :indeterminate="indeterminate"
            :active="active"
            :color="color"
    />
</template>

<script>
import constant from '../constant'
    export default {
        data: () => ({
            absolute: false,
            active: false,
            opacity: 0.22,
            bottom: false,
            buffer: 100,
            fixed: false,
            height: 5,
            indeterminate: true,
            query: false,
            rounded: false,
            stream: false,
            striped: false,
            top: false,
            value: 11,
            color: constant.data().COLOR.add1,
        }),
    }
</script>

<style scoped>

</style>