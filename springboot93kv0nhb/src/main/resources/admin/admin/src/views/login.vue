<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">基于协同过滤算法的运动场馆服务平台设计与实现</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号：
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码：
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item select" v-if="roles.length>1">
						<div class="lable">
							角色：
						</div>
						<el-select v-model="rulesForm.role" placeholder="请选择角色：">
							<el-option v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" :key="item.roleName" :label="item.roleName" :value="item.roleName" />
						</el-select>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
							<el-button type="primary" @click="register('changguanguanli')" class="register">
								注册场馆管理							</el-button>
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
				<div class="idea-box1">还没有账号？现在角色注册</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$router.replace({ path: "/" });
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20241019/1684b266efc9401ea653730564d2631a.webp) no-repeat bottom center;
	background: url(http://codegen.caihongy.cn/20241019/1684b266efc9401ea653730564d2631a.webp) no-repeat bottom center;
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;

	.login_form {
		padding: 0;
		margin: 0;
		z-index: 1000;
		display: flex;
		border-radius: 30px;
		box-shadow: 0px 4px 30px 0px rgba(255,255,255,0.3);
		flex-direction: column;
		overflow: hidden;
		background: rgba(255,255,255,0.5);
		width: 1230px;
		align-items: flex-end;
		position: relative;
		height: 600px;
		.login_form2 {
			background-color: #fff;
			padding: 60px 48px 0 62px;
			width: 500px;
			height: 100%;
		}
		.title-container {
			padding: 0;
			margin: 0;
			color: #333333;
			top: 200px;
			left: 0;
			background: none;
			font-weight: 600;
			width: 730px;
			font-size: 28px;
			line-height: 40px;
			position: absolute;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 0 0 10px;
			display: flex;
			width: calc(100% - 0px);
			align-items: center;
			position: relative;
			flex-wrap: wrap;
			.lable {
				color: #333333;
				width: 100%;
				font-size: 14px;
				line-height: 40px;
				text-align: left;
			}
			input {
				border: 1px solid #efeff7;
				border-radius: 5px;
				padding: 0 10px;
				color: #555555;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			input:focus {
				border: 1px solid #efeff7;
				border-radius: 5px;
				padding: 0 10px;
				color: #555555;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			.password-box {
				display: flex;
				width: 100%;
				position: relative;
				align-items: center;
				input {
					border: 1px solid #efeff7;
					border-radius: 5px;
					padding: 0 10px;
					color: #555555;
					width: 100%;
					font-size: 14px;
					height: 40px;
				}
				input:focus {
					border: 1px solid #efeff7;
					border-radius: 5px;
					padding: 0 10px;
					color: #555555;
					width: 100%;
					font-size: 14px;
					height: 40px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #000;
					top: 0;
					font-size: 16px;
					line-height: 40px;
					position: absolute;
					right: 5px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 14px;
			}
			/deep/ .el-select {
				width: 100%;
			}
			/deep/ .el-select .el-input__inner {
				border: 1px solid rgba(64, 158, 255, 1);
				padding: 0 10px;
				color: rgba(64, 158, 255, 1);
				width: 100%;
				font-size: 14px;
				height: 44px;
			}
			/deep/ .el-select .is-focus .el-input__inner {
				border: 1px solid rgba(85, 170, 0, 1.0);
				padding: 0 10px;
				color: rgba(85, 170, 0, 1.0);
				width: 100%;
				font-size: 14px;
				height: 44px;
			}
			/deep/ .el-select .el-input__inner::placeholder{
				color: #999;
				font-size: 14px;
			}
		}
		.login-btn {
			margin: 20px auto;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 100%;
			}
			.login-btn2 {
				top: 350px;
				left: 0;
				display: flex;
				gap: 20px;
				width: 730px;
				justify-content: center;
				align-items: center;
				position: absolute;
				flex-wrap: wrap;
			}
			.login-btn3 {
				width: 100%;
				order: -1;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #fff;
				background: #BD0D0A;
				font-weight: 600;
				width: 189px;
				font-size: 24px;
				min-width: 68px;
				height: 64px;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 1px solid #000000;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 30px;
				margin: 0 0 10px;
				color: #000000;
				background: transparent;
				width: auto;
				font-size: 16px;
				height: 50px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #000000;
				background: none;
				width: 100%;
				font-size: 15px;
				text-align: left;
				height: 34px;
			}
			.forget:hover {
				color: #0d6efd;
				opacity: 1;
			}
		}
	}
	.idea-box1 {
		top: 300px;
		color: #000000;
		left: 0;
		background: none;
		font-weight: 600;
		width: 730px;
		font-size: 16px;
		position: absolute;
		text-align: center;
		height: 30px;
	}
}

</style>
