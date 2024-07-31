<template>
	<view class="container">
		<view class="title"></view>
		<view class="side-thumb"></view>
		<view class="form-container">
			<view class="form-title"></view>
			<view class="form-body">
				<form @submit="formSubmit">
					<input type="text" class="input-account" placeholder="账号" />
					<input type="text" class="input-pwd" placeholder="密码" />
					<buttom class="submit">登录</buttom>
				</form>
			</view>
		</view>
	</view>
</template>

<script>
</script>

<style scoped lang="scss">
</style>