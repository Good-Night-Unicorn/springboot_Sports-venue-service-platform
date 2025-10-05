<template>
	<view class="content">
		<view :style='{"width":"100%","flexWrap":"wrap","background":"#fff","display":"flex","height":"100%"}'>
			<view class="list-swiper-4" :style='{"width":"100%","position":"relative","height":"360rpx"}' @touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd">
				<view :style='{"width":"100%","position":"absolute","top":"0%","left":"0%","background":"#fff","height":"360rpx"}' class="item animate__animated" :class="prevNumList4 == index  ? 'animate__backOutRight' : (numList4 == index  ? 'animate__backInLeft' : '')" v-for="(swiper,index) in swiperList" :key="index" v-if="numList4 == index || prevNumList4 == index">
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img" @tap="onSwiperTap(swiper)"></image>
					<view :style='{"padding":"8rpx 20rpx","margin":"-20rpx 0 0 0","transform":"translate3d(-50%, -50%, 0)","top":"50%","color":"#000","left":"50%","background":"rgba(255, 255, 255, 0.3)","display":"none","lineHeight":"1.5","fontSize":"40rpx","position":"absolute"}'>{{ swiper.title }}</view>
				</view>
				<view class="animate__navigation" :style='{"alignItems":"center","left":"0%","bottom":"0%","background":"rgba(0,0,0,.3)","display":"flex","width":"100%","position":"absolute","justifyContent":"center","height":"40rpx"}'>
					<block v-for="(swiper,index) in swiperList" :key="index">
						<text class="navigation-item" v-if="numList4 == index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#7C6047","height":"16rpx"}'></text>
						<text class="navigation-item" v-if="numList4 != index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"}'></text>
					</block>
				</view>
			</view>
			<!-- menu -->
			<view v-if="true" class="menu_view">
				<block v-for="(item,index1) in menuList" v-bind:key="item.roleName">
					<block v-if="index1==0" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
						<block v-bind:key="sort" v-for=" (child,sort) in menu.child">
							<block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
								<view class="menu-item" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2(child.tableName)">
									<view class="iconarr" :class="child.appFrontIcon" :style="{'background':menuColor[index]}"></view>
									
									<view class="text">{{child.menu.split("列表")[0]}}</view>
								</view>
							</block>
						</block>
					</block>
				</block>
			</view>
			<!-- 关于我们 -->
			<view :style='{"padding":"0 20rpx","margin":"0 0 20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative","height":"auto","order":"3"}'>
				<view :style='{"padding":"0 0 0 80rpx","margin":"0","alignItems":"center","color":"#7C6047","background":"url(http://codegen.caihongy.cn/20241224/a6508905e50f4e23b13e5c35fe69b548.png) center center/100% 100% no-repeat","display":"flex","width":"100%","fontSize":"36rpx","justifyContent":"space-between","fontWeight":"bold","height":"80rpx"}'>{{aboutUsDetail.title}}</view>
				<view :style='{"margin":"0","color":"#000","textAlign":"center","width":"100%","lineHeight":"60rpx","fontSize":"32rpx","order":"2"}'>{{aboutUsDetail.subtitle}}</view>
				<view :style='{"width":"100%","padding":"20rpx 0 0","flexWrap":"wrap","display":"flex","height":"auto","order":"1"}'>
					<img :style='{"width":"100%","margin":"0 0 20rpx","objectFit":"cover","borderRadius":"20rpx 20rpx 0 0","display":"block","height":"280rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
					<img :style='{"width":"calc(50% - 10rpx)","margin":"0 20rpx 0 0","objectFit":"cover","borderRadius":"0 0 0 20rpx","display":"block","height":"320rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
					<img :style='{"width":"calc(50% - 10rpx)","margin":"0","objectFit":"cover","borderRadius":"0 0 20rpx 0","display":"block","height":"320rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
				</view>
				<view :style='{"padding":"0 0 10rpx","margin":"0 0 20rpx 0","borderColor":"#7C6047","color":"#797979","borderWidth":"0 0 2rpx","width":"100%","lineHeight":"1.5","fontSize":"28rpx","borderStyle":"solid","order":"3"}' v-html="aboutUsDetail.content"></view>
				<view :style='{"border":"0","padding":"0 30rpx","margin":"0 auto","borderColor":"#7C6047","textAlign":"center","display":"block","right":"20rpx","top":"8rpx","background":"none","borderWidth":"2rpx 0 2rpx 2rpx","width":"auto","lineHeight":"60rpx","position":"absolute","borderStyle":"solid"}' @tap="onDetailTap('aboutus',1)">
					<text :style='{"color":"#7C6047","fontSize":"24rpx"}'>更多</text>
					<text class="icon iconfont icon-gengduo1" :style='{"color":"#7C6047","fontSize":"24rpx"}'></text>
				</view>
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			</view>
			<!-- 系统简介 -->
			<view :style='{"padding":"0 20rpx","margin":"0 0 20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative","height":"auto","order":"5"}'>
				<view :style='{"padding":"0 0 0 80rpx","margin":"0","alignItems":"center","color":"#7C6047","background":"url(http://codegen.caihongy.cn/20241224/a6508905e50f4e23b13e5c35fe69b548.png) center center/100% 100% no-repeat","display":"flex","width":"100%","fontSize":"36rpx","justifyContent":"space-between","fontWeight":"bold","height":"80rpx"}'>{{systemIntroductionDetail.title}}</view>
				<view :style='{"margin":"0","color":"#000","textAlign":"center","width":"100%","lineHeight":"60rpx","fontSize":"32rpx","order":"2"}'>{{systemIntroductionDetail.subtitle}}</view>
				<view :style='{"width":"100%","padding":"20rpx 0 0","flexWrap":"wrap","display":"flex","height":"auto","order":"1"}'>
					<img :style='{"width":"100%","margin":"0","objectFit":"cover","borderRadius":"60rpx 0","display":"block","height":"280rpx"}' v-if="systemIntroductionDetail.picture1" :src="baseUrl+systemIntroductionDetail.picture1">
					<img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="systemIntroductionDetail.picture2" :src="baseUrl+systemIntroductionDetail.picture2">
					<img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="systemIntroductionDetail.picture3" :src="baseUrl+systemIntroductionDetail.picture3">
				</view>
				<view :style='{"padding":"0 0 10rpx","margin":"0 0 20rpx 0","borderColor":"#7C6047","color":"#797979","borderWidth":"0 0 2rpx","width":"100%","lineHeight":"1.5","fontSize":"28rpx","borderStyle":"solid","order":"3"}' v-html="systemIntroductionDetail.content"></view>
				<view :style='{"border":"0","padding":"0 30rpx","margin":"0 auto","borderColor":"#7C6047","textAlign":"center","display":"block","right":"20rpx","top":"8rpx","background":"none","borderWidth":"2rpx 0 2rpx 2rpx","width":"auto","lineHeight":"60rpx","position":"absolute","borderStyle":"solid"}' @tap="onDetailTap('systemintro',1)">
					<text :style='{"color":"#7C6047","fontSize":"24rpx"}'>更多</text>
					<text class="icon iconfont icon-gengduo1" :style='{"color":"#7C6047","fontSize":"24rpx"}'></text>
				</view>
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			</view>
			<!-- 商品推荐 -->
			<view class="listBox recommend" :style='{"width":"100%","padding":"0 20rpx","margin":"0 0 20rpx","background":"#fff","order":"4"}'>
				<view class="title" :style='{"padding":"0 0 0 80rpx","margin":"0","alignItems":"center","color":"#7C6047","background":"url(http://codegen.caihongy.cn/20241224/a6508905e50f4e23b13e5c35fe69b548.png) center center/100% 100% no-repeat","display":"flex","width":"100%","fontSize":"36rpx","justifyContent":"space-between","fontWeight":"bold","height":"80rpx"}'>
					<view :style='{"color":"inherit","fontSize":"inherit","lineHeight":"88rpx"}'>运动场馆推荐</view>
				</view>
				<!-- 样式3 -->
				<view class="list-box style3" :style='{"width":"100%","padding":"20rpx 0","margin":"0","height":"auto"}'>
					<view @tap="onDetailTap('yundongchangguan',product.id)" v-for="(product,index) in yundongchangguanlist" :key="index" class="list-item" :style='{"margin":"0 0 20rpx","borderColor":"#7C6047","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
						<image :style='{"width":"260rpx","objectFit":"cover","display":"block","height":"120rpx"}' class="list-item-image" mode="aspectFill" v-if="product.changguantupian.substring(0,4)=='http'" :src="product.changguantupian"></image>
						<image :style='{"width":"260rpx","objectFit":"cover","display":"block","height":"120rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.changguantupian?baseUrl+product.changguantupian.split(',')[0]:''"></image>
						<view class="list-item-body" :style='{"padding":"0","margin":"0","flexWrap":"wrap","display":"flex","width":"calc(100% - 260rpx)","justifyContent":"space-between","height":"auto"}'>
							<view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"70%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.changguanmingcheng}}</view>
							<view :style='{"padding":"0 20rpx","order":"4"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#DAA362"}'></text>
								<text :style='{"color":"#DAA362","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","order":"5"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#DAA362#DAA362"}'></text>
								<text :style='{"color":"#DAA362","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.guanlizhanghao}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"2"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#CE9562"}'></text>
								<text :style='{"color":"#CE9562","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<!-- 商品推荐 -->
			
			<!-- 商品列表 -->
			<!-- 商品列表 -->
			<!-- 新闻资讯 -->
			<view class="listBox news" :style='{"width":"100%","padding":"0 20rpx","margin":"0 0 20rpx","background":"#fff","order":"1"}'>
				<view class="title" :style='{"padding":"0 0 0 80rpx","margin":"0","alignItems":"center","color":"#7C6047","background":"url(http://codegen.caihongy.cn/20241224/a6508905e50f4e23b13e5c35fe69b548.png) center center/100% 100% no-repeat","display":"flex","width":"100%","fontSize":"36rpx","justifyContent":"space-between","fontWeight":"bold","height":"80rpx"}'>
					<view :style='{"color":"inherit","fontSize":"32rpx","lineHeight":"88rpx"}'>系统公告</view>
					<view :style='{"padding":"0 20rpx","borderColor":"#7C6047","alignItems":"center","borderWidth":"2rpx 0 2rpx 2rpx","display":"flex","borderStyle":"solid","justifyContent":"center"}' @tap="onPageTap('news')">
					  <text :style='{"color":"inherit","fontSize":"24rpx","lineHeight":"60rpx"}'>了解更多</text>
					  <text class="icon iconfont icon-gengduo1" :style='{"color":"inherit","fontSize":"24rpx","lineHeight":"60rpx"}'></text>
					</view>
				</view>
				<!-- 样式6 -->
				<view class="news-box3" :style='{"width":"100%","padding":"20rpx 0","margin":"0","height":"auto"}'>
					<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"padding":"8rpx 40rpx","margin":"0","borderColor":"#7C6047","backgroundColor":"rgba(255,255,255,1)","display":"flex","justifyContent":"space-between","borderRadius":"0","flexWrap":"wrap","borderWidth":"0 0 2rpx 0","width":"100%","position":"relative","borderStyle":"solid","height":"auto"}'>
						<view :style='{"padding":"0","boxShadow":"0px 0px 0px #7C6047","margin":"-8rpx 0 0 0","backgroundColor":"#7C6047","top":"50%","left":"16rpx","width":"16rpx","position":"absolute","height":"8rpx"}' class="dian"></view>
						<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="title ">{{item.title}}</view>
						<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#AEAEAE","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="text">{{item.introduction}}</view>
						<view :style='{"padding":"0 20rpx","order":"5"}'>
							<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#DAA362"}'></text>
							<text :style='{"color":"#DAA362","lineHeight":"50rpx","fontSize":"24rpx"}'>{{item.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
						</view>
						<view :style='{"padding":"0 20rpx","order":"4"}'>
							<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#7C6C33"}'></text>
							<text :style='{"color":"#7C6C33","lineHeight":"50rpx","fontSize":"24rpx"}'>{{item.name}}</text>
						</view>
						<view :style='{"padding":"0 20rpx","display":"inline-block","order":"1"}'>
							<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#7C6047"}'></text>
							<text :style='{"color":"#7C6047","lineHeight":"50rpx","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
						</view>
						<view :style='{"padding":"0 20rpx","display":"inline-block","order":"2"}'>
							<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#CE9562"}'></text>
							<text :style='{"color":"#CE9562","lineHeight":"50rpx","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
						</view>
						<view :style='{"padding":"0 20rpx","display":"inline-block","order":"3"}'>
							<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#EBD9AF"}'></text>
							<text :style='{"color":"#EBD9AF","lineHeight":"50rpx","fontSize":"24rpx"}'>{{item.clicknum}}</text>
						</view>
						<view class="cuIcon-right" :style='{"padding":"0","margin":"-36rpx 0 0 0","top":"50%","color":"#666","display":"none","width":"32rpx","lineHeight":"72rpx","fontSize":"32rpx","position":"absolute","right":"0"}'></view>
					</view>
				</view>
			</view>
			<!-- 新闻资讯 -->
			<view v-if="scrollTop>200" @tap="scrollTopClick" :style='{"boxShadow":"0 8rpx 16rpx rgba(0,0,0,.3)","borderRadius":"50%","textAlign":"center","bottom":"20%","background":"#ff000030","width":"60rpx","lineHeight":"60rpx","position":"fixed","right":"20rpx","height":"60rpx"}'>
				<span class="icon iconfont icon-jiantou07" :style='{"color":"#fff"}'></span>
			</view>
		</view>
	</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				startX: 0,
				prevNumList4: '',
				numList4: 0,
				timerList4: null,
				flagList4: false,
				navigationActive: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#7C6047","height":"16rpx"},
				navigationDefault: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"},
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
					'cuIcon-same',
					'cuIcon-deliver',
					'cuIcon-evaluate',
					'cuIcon-shop',
					'cuIcon-ticket',
					'cuIcon-cascades',
					'cuIcon-discover',
					'cuIcon-question',
					'cuIcon-pic',
					'cuIcon-filter',
					'cuIcon-footprint',
					'cuIcon-pulldown',
					'cuIcon-pullup',
					'cuIcon-moreandroid',
					'cuIcon-refund',
					'cuIcon-qrcode',
					'cuIcon-remind',
					'cuIcon-profile',
					'cuIcon-home',
					'cuIcon-message',
					'cuIcon-link',
					'cuIcon-lock',
					'cuIcon-unlock',
					'cuIcon-vip',
					'cuIcon-weibo',
					'cuIcon-activity',
					'cuIcon-friendadd',
					'cuIcon-friendfamous',
					'cuIcon-friend',
					'cuIcon-goods',
					'cuIcon-selection'
				],
				role : '',
				aboutUsDetail: {},
				systemIntroductionDetail: {},
				menuList: [],
				swiperMenuList:[],
				user: {},
				tableName:'',
				menuColor: '#67c23a,#351c6c,#f56c6c,#503319,#a21233,#7C6047,#EBD9AF,#7C6C33,#DAA362,#e6a23c'.split(','),

				//轮播
				swiperList: [],
				yundongchangguanlist: [],
				news: [],
				scrollTop: 0,
			}
		},
		onPageScroll(e) {
			this.scrollTop = e.scrollTop
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
			this.menuColor = this.menuColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		async onShow() {
			if (this.timerList4&&this.timerList4!=null) clearInterval(this.timerList4)
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
				if(key==0) {
					item.frontMenu.forEach((item2,key2) => {
						if(item2.child[0].buttons.indexOf("查看")>-1) {
							this.swiperMenuList.push(item2);
						}
					})
				}
			})
			// let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
						title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			
			this.prevNumList4 = this.swiperList.length - 1
			this.timerList4 = setInterval(this.autoPlayList4, 3000)

			this.getAboutUs();
			this.getSystemIntroduction();
			// 推荐信息
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},
		methods: {
			scrollTopClick(){
				uni.pageScrollTo({
					scrollTop: 0
				})
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				// 系统公告
				res = await this.$api.list('news', params)
				this.news = res.data.list
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
				// 推荐信息
				params = {
					page: 1,
					limit: 6,
				}
				if(uni.getStorageSync("appUserid")) {
					res = await this.$api.recommend2('yundongchangguan', params);
				} else {
					res = await this.$api.recommend('yundongchangguan', params);
				}
				this.yundongchangguanlist = res.data.list
				

			},
			autoPlayList4() {
				this.prevNumList4 = this.numList4
			
				this.numList4++
				if (this.numList4 == this.swiperList.length) this.numList4 = 0
			},
			touchStart(event) {
				this.startX = event.touches[0].clientX
				
				clearInterval(this.timerList4)
				this.flagList4 = true
			},
			touchMove(event) {
				const currentX = event.touches[0].clientX;
				const deltaX = currentX - this.startX;
				
				if (deltaX > 50) {
					// 向右滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4++
						if (this.numList4 == this.swiperList.length) this.numList4 = 0
					}
					
				} else if (deltaX < -50) {
					// 向左滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4--
						if (this.numList4 < 0) this.numList4 = this.swiperList.length - 1
					}
				}
			},
			touchEnd() {
				this.startX = 0
				this.timerList4 = setInterval(this.autoPlayList4, 3000)
				this.flagList4 = false
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						// #ifdef MP-WEIXIN
						uni.navigateTo({
						    url: '../../common/linkOthers/linkOthers?url=' + encodeURIComponent(e.url),
						});
						return false
						// #endif
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
			async getAboutUs() {
				let res = await this.$api.info('aboutus', 1)
				this.aboutUsDetail = res.data;
			},
			async getSystemIntroduction() {
				let res = await this.$api.info('systemintro', 1)
				this.systemIntroductionDetail = res.data;
			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
			onPageTap2(index) {
				let url = '../' + index + '/list'
				if(index=='forum'){
					url = '../forum-index/forum-index'
				}
				uni.setStorageSync("useridTag",0);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.list-swiper-4 .animate__animated {
		--animate-delay: 300ms;
	}

	.menu_view {
		padding: 0;
		margin: 0 0 20rpx;
		background: #fff;
		display: flex;
		width: 100%;
		justify-content: space-between;
		flex-wrap: wrap;
		height: auto;
		.menu-item {
			padding: 12rpx 0;
			margin: 10rpx 1% 0;
			width: 23%;
			height: auto;
			.iconarr {
				border-radius: 10rpx;
				padding: 0;
				margin: 0px auto;
				color: #fff;
				background: #fff;
				display: block;
				width: 70rpx;
				font-size: 40rpx;
				line-height: 70rpx;
				text-align: center;
				height: 70rpx;
			}
			.text {
				padding: 0;
				margin: 8rpx auto 0;
				color: #7C6047;
				width: 100%;
				font-size: 26rpx;
				line-height: 28rpx;
				text-align: center;
			}
		}
	}
</style>
