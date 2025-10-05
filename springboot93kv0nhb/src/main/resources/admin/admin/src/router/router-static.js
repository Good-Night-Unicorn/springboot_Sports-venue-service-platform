import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import news from '@/views/modules/news/list'
	import aboutus from '@/views/modules/aboutus/list'
	import discusssaishihuodong from '@/views/modules/discusssaishihuodong/list'
	import zaizhiyuangong from '@/views/modules/zaizhiyuangong/list'
	import saishidongtai from '@/views/modules/saishidongtai/list'
	import shijianduan from '@/views/modules/shijianduan/list'
	import storeup from '@/views/modules/storeup/list'
	import changguanguanli from '@/views/modules/changguanguanli/list'
	import yundongchangguan from '@/views/modules/yundongchangguan/list'
	import changguanleixing from '@/views/modules/changguanleixing/list'
	import saishihuodong from '@/views/modules/saishihuodong/list'
	import systemintro from '@/views/modules/systemintro/list'
	import changguanyuding from '@/views/modules/changguanyuding/list'
	import yonghu from '@/views/modules/yonghu/list'
	import orders from '@/views/modules/orders/list'
	import saishibaoming from '@/views/modules/saishibaoming/list'
	import discussyundongchangguan from '@/views/modules/discussyundongchangguan/list'
	import config from '@/views/modules/config/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/news',
		name: '系统公告',
		component: news
	}
	,{
		path: '/aboutus',
		name: '关于我们',
		component: aboutus
	}
	,{
		path: '/discusssaishihuodong',
		name: '赛事活动评论',
		component: discusssaishihuodong
	}
	,{
		path: '/zaizhiyuangong',
		name: '在职员工',
		component: zaizhiyuangong
	}
	,{
		path: '/saishidongtai',
		name: '赛事动态',
		component: saishidongtai
	}
	,{
		path: '/shijianduan',
		name: '时间段',
		component: shijianduan
	}
	,{
		path: '/storeup',
		name: '我的收藏',
		component: storeup
	}
	,{
		path: '/changguanguanli',
		name: '场馆管理',
		component: changguanguanli
	}
	,{
		path: '/yundongchangguan',
		name: '运动场馆',
		component: yundongchangguan
	}
	,{
		path: '/changguanleixing',
		name: '场馆类型',
		component: changguanleixing
	}
	,{
		path: '/saishihuodong',
		name: '赛事活动',
		component: saishihuodong
	}
	,{
		path: '/systemintro',
		name: '系统简介',
		component: systemintro
	}
	,{
		path: '/changguanyuding',
		name: '场馆预订',
		component: changguanyuding
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/orders/:status',
		name: '订单管理',
		component: orders
	}
	,{
		path: '/saishibaoming',
		name: '赛事报名',
		component: saishibaoming
	}
	,{
		path: '/discussyundongchangguan',
		name: '运动场馆评论',
		component: discussyundongchangguan
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/newstype',
		name: '系统公告分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
